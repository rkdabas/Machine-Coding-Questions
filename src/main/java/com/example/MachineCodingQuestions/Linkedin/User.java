package com.example.MachineCodingQuestions.Linkedin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userId;
    private String name;
    private String email;
    private String password;
    private Profile profile;
    private List<Connection>connections;
    private List<Message>inbox;
    private List<Message>sentMessages;
}
