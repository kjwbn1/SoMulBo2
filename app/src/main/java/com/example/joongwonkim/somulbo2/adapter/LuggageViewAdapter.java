//package com.example.joongwonkim.somulbo2.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//
//import com.example.joongwonkim.somulbo2.R;
//
//public class LuggageViewAdapter extends BaseAdapter{
//
//    Context context;
//    int Layout;
//    int img[];
//    LayoutInflater inflater;
//
//
//    public LuggageViewAdapter(Context context, int layout , int[] img){
//        this.context = context;
//        this.Layout = layout;
//        this.img = img;
//        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }
//
//
//    @Override
//    public int getCount() {
//        return img.length;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return img[position];
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
////    @Override
////    public View getView(int position, View convertView, ViewGroup parent) {
////        if (convertView == null)
////            convertView = inflater.inflate(Layout, null);
//////        ImageView iv = (ImageView)convertView.findViewById(R.id.luggage_image);
////        iv.setImageResource(img[position]);
//
//
//
//
////        return convertView;
//    }
//}
