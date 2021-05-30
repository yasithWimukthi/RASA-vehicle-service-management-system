package com.rasa.util;

public class EmpQuery {

    //emp detail management queries

    public static final String add_emp ="";

    public static final String update_emp ="";

    public static final String show_emp=" ";

    public static final String all_emp ="select * from salary ";

    public static final String del_emp =" ";


    //emp payment management queries


    public static final String add_adv ="INSERT INTO advance(employeeID,amount) VALUES(?,?)";

    public static final String update_adv ="update advance set amount=? where employeeID=?";

    public static final String show_adv=" select employeeID,amount from advance order by advanceID desc limit 1;";

    public static final String all_adv ="select * from advance";

    public static final String del_adv ="delete from advance order by advanceID desc limit 1 ";


    public static final String add_sal ="insert into salary(employeeId,bonus,deduct,amount) values(?,?,?,?)";

    public static final String update_sal ="";

    public static final String show_sal="select * from salary";

    public static final String all_sal ="select * from salary";


    //emp attendance management queries

    public static final String add_att ="INSERT INTO attendance(employeeID,status) VALUES(?,?)";

    public static final String update_att ="";

    public static final String all_att ="select * from attendance";


    //retrieve

    public static final String to_EmpPay_table="select * from employee";

    public static final String to_EmpAtt_table="select * from employee where employeeID not in(select employeeID from attendance where att_date=CURRENT_DATE) ";

}
