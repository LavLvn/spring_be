package com.javaremotero69.spring_be.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    Pasi pentru instalarea pluginului Lombok:
    File -> Settings -> Plugins -> Marketplace -> search bar (cautati dupa keyword-ul Lombok) -> Install -> Apply & Ok
    (posibil restart la IntelliJ dupa)

    @Data = @Setter + @Getter + @ToString + alte metode overrided (equals si hashCode)
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {

    private String text;
}
