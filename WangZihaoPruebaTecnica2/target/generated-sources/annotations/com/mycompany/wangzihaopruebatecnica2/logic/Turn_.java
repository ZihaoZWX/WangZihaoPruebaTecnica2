package com.mycompany.wangzihaopruebatecnica2.logic;

import com.mycompany.wangzihaopruebatecnica2.logic.Users;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-01-19T16:46:52")
@StaticMetamodel(Turn.class)
public class Turn_ { 

    public static volatile SingularAttribute<Turn, LocalDate> turnDate;
    public static volatile SingularAttribute<Turn, String> province;
    public static volatile SingularAttribute<Turn, String> turnProcedure;
    public static volatile SingularAttribute<Turn, String> postalCode;
    public static volatile SingularAttribute<Turn, String> description;
    public static volatile SingularAttribute<Turn, String> id;
    public static volatile SingularAttribute<Turn, String> office;
    public static volatile SingularAttribute<Turn, String> turnState;
    public static volatile SingularAttribute<Turn, Users> users;

}