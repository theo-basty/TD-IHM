package diatorker.com.tdihm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.activity_main_button_edit) Button buttonEdit;
    @BindView(R.id.activity_main_names) RecyclerView namesView;
    NameAdapter nameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        nameAdapter = new NameAdapter();

        initList();

        buttonEdit.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameAdapter.updateList(DataManager.getInstance().getNameList());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_button_edit:
                Intent intent = new Intent(this, EditActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void initList(){
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        namesView.setLayoutManager(linearLayoutManager);
        namesView.setAdapter(nameAdapter);
    }
}
