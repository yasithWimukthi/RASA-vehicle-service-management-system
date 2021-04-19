package com.rasa.util;

public class EmpQuery {

    //emp detail management queries

    public static final String add_emp ="";

    public static final String update_emp ="";

    public static final String show_emp=" ";

    public static final String all_emp =" ";

    public static final String del_emp =" ";


    //emp payment management queries


    public static final String add_adv ="INSERT INTO advance(empID,amount) VALUES(?,?)";

    public static final String update_adv ="update advance set empID=?,Amount=?";

    public static final String show_adv=" select empID,amount from advance order by advanceID desc limit 1;";

    public static final String all_adv ="select * from advance";

    public static final String del_adv ="delete from advance order by advanceID desc limit 1 ";


    public static final String add_sal ="";

    public static final String update_sal ="";

    public static final String show_sal="select * from salary";

    public static final String all_sal ="select * from salary";


    //emp attendance management queries

    public static final String add_att ="";

    public static final String update_att ="";

    public static final String all_att ="select * from attendance";


    //retrieve

    public static final String to_EmpPay_table="select employeeID,fname,lname from empnadu.emp";

    public static final String to_EmpAtt_table="";

}
