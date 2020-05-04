package br.com.producer.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    private String body;
    private String title;

}
