package com.example.deliveryapp.queries;

public class UserQuery {

        public static final String updateUserQuery = "Update User u set u.firstName = ?1, u.lastName = ?2, u.username = ?3, u.address = ?4 where u.id = ?5";

}
