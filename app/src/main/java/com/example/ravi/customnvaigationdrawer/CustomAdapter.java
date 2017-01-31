package com.example.ravi.customnvaigationdrawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi on 31-01-2017.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>
{
    List<Model> modelList=new ArrayList<>();
     Context mContext;



    public CustomAdapter(List<Model> modelList, Context mContext) {
        this.modelList = modelList;
        this.mContext = mContext;
    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.list_item_row, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(mContext));
                       Model model= modelList.get(position);

        holder.textView.setText(""+model.getName());
        imageLoader.displayImage(model.getImage(),holder.imageView);

    }



    @Override
    public int getItemCount() {
        return modelList.size();
    }
    public  static  class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public CustomViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_name);
            imageView= (ImageView) itemView.findViewById(R.id.image);


        }
    }




}
