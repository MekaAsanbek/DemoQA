package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.Employee;
import com.demoqa.utils.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class WebTablePage extends BasePage{

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewBtn;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "age")
    public WebElement ageInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "salary")
    public WebElement salaryInput;

    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    private int index;

    public ArrayList<String> emails = new ArrayList<>();
    // добавляем сотрудника проверяя в списке на наличие похожего email
    public WebTablePage addNewEmployee(Employee employee) throws Exception {
        webElementActions.click(addNewBtn)
                .sendKeys(firstNameInput, employee.getFirstName())
                .sendKeys(lastNameInput, employee.getLastName())
                .sendKeys(emailInput, employee.getEmail())
                .sendKeys(ageInput, String.valueOf(employee.getAge()))
                .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
                .sendKeys(departmentInput, employee.getDepartment());
        getEmployeesAndEmailFromTable();
        if (emails.contains(employee.getEmail())) {
            throw new Exception("Сотрудник с таким email уже существует!");
        } else {
            webElementActions.click(submitBtn);
        }
        return this;
    }

    // получаем список сотрудников
    public ArrayList<Employee> getEmployeesFromTable() {
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        ArrayList<Employee> employees = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() || department.isEmpty()) {
                continue;
            }

            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim());

            employees.add(new Employee(firstName, lastName, age, email, salary, department));
        }
        return employees;
    }

    // получаем список сотрудников и отдельный список их email
    public ArrayList<Employee> getEmployeesAndEmailFromTable() throws Exception {
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        ArrayList<Employee> employees = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() || department.isEmpty()) {
                continue;
            }

            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim());

            if (!emails.contains(email)) { // Проверяем на уникальность перед добавлением
                emails.add(email);
            }
            employees.add(new Employee(firstName, lastName, age, email, salary, department));
        }
        return employees;
    }

    // удаление из списка. Рандомно выбирает email, по выбранному email сформирует xPath нужной кнопки удаления и нажимает
    public void removeFromList () {

        if (emails.isEmpty()) {
            System.out.println("Список email пуст.");
            return;
        }

        Random random = new Random();
        int index = random.nextInt(emails.size());
        String email = emails.get(index);

        System.out.println("Выбранный индекс: " + index + ", Email: " + email);

        for (int i = 0; i < emails.size(); i++) {
            if (emails.get(i).equals(email)) {
                String xpath = String.format("//*[@id='delete-record-%d']", i + 1);
                System.out.println("Сформированный XPath: " + xpath);
                try {
                    WebElement deleteBtn = DriverManager.getDriver().findElement(By.xpath(xpath));
                    webElementActions.jsClick(deleteBtn);
                    System.out.println("Элемент удалён: " + email);
                    emails.remove(email); // Удаляем email из списка после успешного удаления элемента
                } catch (NoSuchElementException e) {
                    System.out.println("Элемент не найден для удаления: " + email);
                }
                break;
            }
        }
    }

    // редактирование полей. Рандомно выбираем сотрудника и рандомно выбираем несколько полей для редактирования
    public void editRandomFields() throws Exception {
        // Получаем список сотрудников
        List<Employee> employees = getEmployeesAndEmailFromTable();
        if (employees.isEmpty()) {
            System.out.println("Список сотрудников пуст.");
            return;
        }

        // Рандомно выбираем сотрудника из списка
        Random random = new Random();
        index = random.nextInt(employees.size());
        Employee randomEmployee = employees.get(index);

        System.out.println("Выбранный сотрудник для редактирования: " + randomEmployee);

        // Случайно выбираем количество полей для редактирования (от 1 до 6 полей)
        int numFieldsToEdit = random.nextInt(6) + 1;

        // Создаем новый объект Employee с новыми значениями полей
        Employee newValues = RandomUtils.createMockEmployee();

        Set<Integer> chosenIndices = new HashSet<>();

        // Открываем форму редактирования сотрудника
        String xpath = String.format("//*[@id='edit-record-%d']", index + 1);
        WebElement editButton = DriverManager.getDriver().findElement(By.xpath(xpath));
        webElementActions.jsClick(editButton);

        for (int i = 0; i < numFieldsToEdit; i++) {
            // Генерируем случайное поле для редактирования, которое еще не было выбрано
            int fieldIndex = random.nextInt(6);
            while (chosenIndices.contains(fieldIndex)) {
                fieldIndex = random.nextInt(6);
            }
            chosenIndices.add(fieldIndex);

            System.out.println("Chosen field index: " + fieldIndex); // Возможные индексы: 0 - firstName, 1 - lastName, 2 - age, 3 - email, 4 - salary, 5 - department

            String fieldName = "";

            switch (fieldIndex) {
                case 0:
                    fieldName = "firstName";
                    webElementActions.clearAndSendKeys(firstNameInput, newValues.getFirstName());
                    randomEmployee.setFirstName(newValues.getFirstName());
                    break;
                case 1:
                    fieldName = "lastName";
                    webElementActions.clearAndSendKeys(lastNameInput, newValues.getLastName());
                    randomEmployee.setLastName(newValues.getLastName());
                    break;
                case 2:
                    fieldName = "age";
                    webElementActions.clearAndSendKeys(ageInput, String.valueOf(newValues.getAge()));
                    randomEmployee.setAge(newValues.getAge());
                    break;
                case 3:
                    fieldName = "email";
                    webElementActions.clearAndSendKeys(emailInput, newValues.getEmail());
                    randomEmployee.setEmail(newValues.getEmail());
                    break;
                case 4:
                    fieldName = "salary";
                    webElementActions.clearAndSendKeys(salaryInput, String.valueOf(newValues.getSalary()));
                    randomEmployee.setSalary(newValues.getSalary());
                    break;
                case 5:
                    fieldName = "department";
                    webElementActions.clearAndSendKeys(departmentInput, newValues.getDepartment());
                    randomEmployee.setDepartment(newValues.getDepartment());
                    break;
                default:
                    System.out.println("Неверный индекс поля.");
                    return;
            }
            System.out.println("Обновлено поле '" + fieldName + "' для сотрудника: " + randomEmployee.getFirstName() + " " + randomEmployee.getLastName());
        }
        // Сохраняем изменения
        webElementActions.jsClick(submitBtn);
    }


//
//    // это метод который нажимает на кнопку Add и заполняет форму
//    public WebTablePage addNewEmployee(Employee employee){
//        webElementActions.click(addNewBtn)
//                .sendKeys(firstNameInput, employee.getFirstName())
//                .sendKeys(lastNameInput, employee.getLastName())
//                .sendKeys(ageInput, String.valueOf(employee.getAge()))
//                .sendKeys(emailInput, employee.getEmail())
//                .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
//                .sendKeys(departmentInput, employee.getDepartment())
//                .click(submitBtn);
//        return this;
//
//    }
//
//    //Это метод который собирает в лист всех сотрудников из таблицы
//    public ArrayList<Employee> getEmployeesFromTable(){
//        // этот лист для хранения всего списка (строки(10 строк) со всеми данными каждого сотрудника)
//        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable.rt-tr-group"));
//
//
//        // Создаем пустой список сотрудников
//        ArrayList<Employee> employees = new ArrayList<>();
//        // в этом эррайлисте мы будем брать по одной строке с Листа<WebElement> с данными сотрудника
//        // и будем отдельно искать каждую ячейку(имя, фамилия, возраст и тд), потом через сеттеры присваивать к объектам
//
//        // перебираем в цикле весь список. Проходим по каждой строке таблицы
//        for (WebElement row: rows) {
//            // Лист для хранения столбцов(имя, фамилия, возраст и тд) по данным одной строки(одного сотрудника)
//            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
//            // Извлекаем текст из ячеек и сохраняем в переменные
//            String firstName = cells.get(0).getText(); // по индексу берем и сохраняем в Стринг
//            String lastName = cells.get(1).getText();
//            String ageText = cells.get(2).getText().replaceAll("[^0-9]", ""); // regex - это регулярные выражения, то есть удаляет все символы кроме цифр
//            String email = cells.get(3).getText();
//            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", ""); // используется если не срабатывает валидация и сохраняется неправильный формат(буквы и символы), то он их заменяет на пустоту
//            String department = cells.get(5).getText();
//
//            // задача не добавлять пустые строки, а только заполненные
//            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() || department.isEmpty()) {
//                continue; //Если какое-то из полей пустое, пропускаем эту строку
//            }
//            int age = Integer.parseInt(ageText.trim());  // Стринг парсим в инт и в лонг
//            long salary = Long.parseLong(salaryText.trim()); //убираем пробелы если есть
//
//            employees.add(new Employee(firstName, lastName, age, email, salary, department));
//        } // ложим в список эррайлист первый обьект Эмплойи(с именем и тд), потом второй объект и так дальше, то ест создаем объект Employee и добавляем его в список сотрудников
//        return employees;
//        // Возвращаем список сотрудников
//    }


}
