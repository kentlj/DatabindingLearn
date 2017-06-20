package com.learn.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.learn.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    Person p = new Person("yui", "18");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //        xml加入id 可以去除findid步骤
        //        binding.name.setText("")
        binding.setPerson(p);
        //        binding.setVariable(com.learn.databinding.BR.person,p);
        binding.setHandler(new MyHandler());
        binding.viewStub.getViewStub().inflate();

    }

    public class MyHandler {
        //        方法引用 方法参数相同（方法名可不同）
        public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
            p.setName(text.toString());
            p.setAge("222");
//            ObservableBoolean 控制view的显示与否
           p.setIsFemale(!p.getIsFemale().get());
//            binding.setPerson(p);
        }

        //        监听器引用  更灵活 lambda表达式
        public void clickOnText(Person person) {
            Toast.makeText(MainActivity.this, person.toString(), Toast.LENGTH_SHORT).show();

        }
    }
}
