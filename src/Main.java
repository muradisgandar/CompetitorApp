import beans.User;
import config.Initilization;
import util.MenuUtil;
import util.UserUtil;
/*
0.login olmaq teleb olunur 3 defe sehv olarsa xeta versin ve sistemden atsin
1.menu chixir ve mene gosterir ki ne etmek isteryrisen
2.yarishmacilari daxil et ad soyad yash sorushulur menden
3.yarishmaya bashla emri var randoim eded atir sistemm arXA planda eger duz tapsam qalib oluram
4.logout sechilerse sistemden chixilir
 */

public class Main {


    public static void main(String[] args) {

        User user =  UserUtil.requiredInputAndLogin(3,true);

        Initilization.initializeConfig(user);
        System.out.println("Hello "+user.getName());
        MenuUtil.showMenuInfinite();




    }
}
