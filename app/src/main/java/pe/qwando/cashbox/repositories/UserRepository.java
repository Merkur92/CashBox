package pe.qwando.cashbox.repositories;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.orm.SugarRecord;

import pe.qwando.cashbox.models.User;

public class UserRepository {
    private static final String TAG = UserRepository.class.getSimpleName();
    public static User save(Context context, String name, String lastname, String email, String password) throws Exception {
        try {
            Long time = System.currentTimeMillis();
            User user = new User();
            user.setId(time);
            user.setName(name);
            user.setLastname(lastname);
            user.setEmail(email);
            user.setPassword(password);
            SugarRecord.save(user);
            return user;
        } catch (Exception e){
            Log.e(TAG, e.toString(), e);
            throw e;
        }

    }
}
