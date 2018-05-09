import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.pojo.Person;
import jdk.internal.util.xml.impl.Input;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/9 10:07
 */
public class Main {

    public static void main(String[] args) throws IOException {
        /*Person person = new Person("李小龙",23,"香港","asfjlkjalskfjlaf");
        Person person1 = new Person("李小虎",24,"北京","sdfjklsdjflksjdf");
        Person person2= new Person("lichenxin",23,"chongqing","asfjksdjflksdjf");
        Person person3 = new Person("lichenxin",23,"chongqing","dfkskdjfskdfjkjdf");
        List list = new ArrayList();
        list.add(person);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        String s = JSON.toJSONString(list);
        System.out.println(s);*/

        String path = Main.class.getClassLoader().getResource("data.json").getPath();
        String s = FileUtils.readFileToString(new File(path), "UTF-8");
        List list = (List) JSONObject.parseArray(s);

        System.out.println(list.size());


    }

}
