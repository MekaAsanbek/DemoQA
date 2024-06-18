package com.demoqa.entities;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder   //Билдер помогает создавать сложные обьекты(сложные значит: обьекты с множеством полей, с зависимыми полями,
// объекты с логикой инициализации)

// В программировании и разработке баз данных "Entity" (сущность) — это абстракция, представляющая объекты реального мира или системы.

public class TextBoxEntity {

    private String fullName;
    private String email;
    private String currentAddress;
    private String permanentAddress;

}
