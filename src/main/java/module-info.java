module com.quizplus.tasktwo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.compiler;
    requires java.sql;
    requires org.mapstruct;
    requires lombok;


    opens com.quizplus.tasktwo to javafx.fxml, org.hibernate.orm.core;
    exports com.quizplus.tasktwo;
    opens com.quizplus.tasktwo.Models to javafx.fxml, org.hibernate.orm.core;
    exports com.quizplus.tasktwo.Models;
    opens com.quizplus.tasktwo.Controller to javafx.fxml, org.hibernate.orm.core;
    exports com.quizplus.tasktwo.Controller;

}