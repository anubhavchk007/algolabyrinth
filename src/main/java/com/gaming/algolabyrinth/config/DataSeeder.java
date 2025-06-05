package com.gaming.algolabyrinth.config;

import com.gaming.algolabyrinth.model.Room;
import com.gaming.algolabyrinth.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired private RoomRepository roomRepository;

    @Override
    public void run(String... args) {
        if (roomRepository.count() > 0) return;

        Room r1 = new Room();
        r1.setLevel(1);
        r1.setTitle("Sum of Two Numbers");
        r1.setDescription("Given two integers, return their sum.");
        r1.setInputCases(Arrays.asList("2 3", "10 20", "-5 5"));
        r1.setExpectedOutputs(Arrays.asList("5", "30", "0"));
        r1.setForbiddenKeywords(Arrays.asList("System.exit", "Runtime"));

        Room r2 = new Room();
        r2.setLevel(2);
        r2.setTitle("Palindrome Check");
        r2.setDescription("Check whether a given string is a palindrome.");
        r2.setInputCases(Arrays.asList("madam", "racecar", "hello"));
        r2.setExpectedOutputs(Arrays.asList("true", "true", "false"));
        r2.setForbiddenKeywords(Arrays.asList("reverse", "StringBuilder"));

        roomRepository.saveAll(Arrays.asList(r1, r2));
        System.out.println("✅ Sample rooms seeded.");
    }
}
