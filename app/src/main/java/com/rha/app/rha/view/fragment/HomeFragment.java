package com.rha.app.rha.view.fragment;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Environment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.rha.app.rha.R;
import com.rha.app.rha.view.adapters.ListBrandAdapter;
import com.rha.app.rha.view.adapters.ListCategoriesAdapter;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends android.support.v4.app.Fragment {

    private String TAG = HomeFragment.class.getSimpleName();
    private RecyclerView mlistCategories;
    private RecyclerView mlistBrands;
    private EditText mSearch;
    private ListBrandAdapter mBrandAdapter;
    private ListCategoriesAdapter mCategoriesAdapter;
    private ArrayList<String> mListCategories;
    private ArrayList<String> mListBrands;

    public static HomeFragment getInstanace() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    public HomeFragment() {

        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        mlistBrands = (RecyclerView)rootView.findViewById(R.id.listBrands);
        mlistCategories = (RecyclerView)rootView.findViewById(R.id.listCategories);
        mSearch = (EditText)rootView.findViewById(R.id.edtSearch);
        mBrandAdapter = new ListBrandAdapter(getActivity(),mListBrands);
        mCategoriesAdapter = new ListCategoriesAdapter(getActivity(),mListCategories);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mlistCategories.setLayoutManager(mLayoutManager);
        RecyclerView.LayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(),3);
        mlistBrands.setLayoutManager(mGridLayoutManager);

        return rootView;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void initView(View convertView) {

    }


}
