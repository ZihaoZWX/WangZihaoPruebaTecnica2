package com.mycompany.wangzihaopruebatecnica2.logic;

import com.mycompany.wangzihaopruebatecnica2.logic.Turn;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-01-19T16:46:52")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> gmail;
    public static volatile SingularAttribute<Users, String> phoneNumber;
    public static volatile SingularAttribute<Users, String> surname;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile SingularAttribute<Users, String> id;
    public static volatile ListAttribute<Users, Turn> turn;

}