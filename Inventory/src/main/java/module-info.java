module bg.tu_varna.sit.inventory {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires log4j;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;

    opens bg.tu_varna.sit.inventory.data.entities to org.hibernate.orm.core;
    exports bg.tu_varna.sit.inventory.data.entities;

    opens bg.tu_varna.sit.inventory.data.access to org.hibernate.orm.core;
    exports bg.tu_varna.sit.inventory.data.access;

    exports bg.tu_varna.sit.inventory.application;
    opens bg.tu_varna.sit.inventory.application to javafx.fxml;

    exports bg.tu_varna.sit.inventory.presentation.controllers;
    opens bg.tu_varna.sit.inventory.presentation.controllers to javafx.fxml;

    exports bg.tu_varna.sit.inventory.presentation.models;
    opens bg.tu_varna.sit.inventory.presentation.models to javafx.fxml;
}