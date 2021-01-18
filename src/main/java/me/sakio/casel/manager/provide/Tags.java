package me.sakio.casel.manager.provide;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Tags {
    //ADD MORE TAG WITH THIS FORMAT ("perms"/"TAG"/"TAG_NAME")
    DEFAULT("default", "&4[Default_Tag]", "default.casel"),
    CASE_1("Test_1", "&c[Test]", "test.casel");


    private final String name;
    private final String prefix;
    private final String permission;

}
