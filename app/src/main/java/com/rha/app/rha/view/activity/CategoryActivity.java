package com.rha.app.rha.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import com.rha.app.rha.R;
import com.rha.app.rha.model.User;
import com.rha.app.rha.view.adapters.CategoryAdapter;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
 ListView listCategory;
 CategoryAdapter mAdapter;
 ArrayList<User> catList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_category);
        listCategory = (ListView) findViewById(R.id.list_category);
        mAdapter = new CategoryAdapter(CategoryActivity.this,catList);
        listCategory.setAdapter(mAdapter);
    }
}
