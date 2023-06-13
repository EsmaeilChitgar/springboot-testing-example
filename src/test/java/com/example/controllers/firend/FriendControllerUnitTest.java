package com.example.controllers.firend;

import com.example.controllers.FriendController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FriendControllerUnitTest {
    @Test
    void hello() {
        FriendController controller = new FriendController(); // Arrange
        String response = controller.hello("friend"); // Act
        assertEquals("Hello, friend", response);// Assert
    }
}