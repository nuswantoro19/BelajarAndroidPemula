package com.dicoding.assosiate.tesrecycleronline;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CategoryViewHolder> {
    private ArrayList<MovieItems> mData;
    private Context context;
    final private String POSTER_PATH="http://image.tmdb.org/t/p/w342/";

    MovieAdapter(Context context){
        this.context=context;
    }

    void setData(ArrayList<MovieItems> mData){
        this.mData=mData;
    }
    public void addItem(final MovieItems item){
        mData.add(item);
        notifyDataSetChanged();
    }
    ArrayList<MovieItems> getListData(){
        return mData;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_row,parent,false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListData().get(position).getTitle());
        holder.tvRemarks.setText(getListData().get(position).getRelease());
        Glide.with(context)
                .load(POSTER_PATH+getListData().get(position).getPoster_path())
                .override(55,55)
                .crossFade()
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListData().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        CategoryViewHolder(View itemView){
            super(itemView);
            tvName=(TextView)itemView.findViewById(R.id.tv_movie_name);
            tvRemarks=(TextView)itemView.findViewById(R.id.tv_movie_date);
            imgPhoto=(ImageView)itemView.findViewById(R.id.img_poster);
        }
    }
}


/*public class MovieAdapter extends BaseAdapter{
    private ArrayList<MovieItems> mData=new ArrayList<>();
    private LayoutInflater mInflater;
    private Context context;
    final private String POSTER_PATH="http://image.tmdb.org/t/p/w342/";
    public MovieAdapter(Context context){
        this.context=context;
        mInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(ArrayList<MovieItems> items){
        mData=items;
        notifyDataSetChanged();
    }
    public void addItem(final MovieItems item){
        mData.add(item);
        notifyDataSetChanged();
    }
    public void clearData(){
        mData.clear();
    }

    @Override
    public int getItemViewType(int position){
        return 0;
    }
    @Override
    public int getViewTypeCount() {
        return 1;
    }
    @Override
    public int getCount() {
        if (mData == null) return 0;
        return mData.size();
    }

    @Override
    public MovieItems getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.movie_item_row,null);
            holder.textViewJudul=(TextView)convertView.findViewById(R.id.tv_movie_name);
            holder.textViewDate=(TextView)convertView.findViewById(R.id.tv_movie_date);
            holder.imageViewPoster=(ImageView)convertView.findViewById(R.id.img_poster);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        holder.textViewJudul.setText(mData.get(position).getTitle());
        holder.textViewDate.setText(mData.get(position).getRelease());
        Glide.with(context)
                .load(POSTER_PATH+mData.get(position).getPoster_path())
                .override(150,300)
                .into(holder.imageViewPoster);
        return convertView;
    }
    private class ViewHolder{
        TextView textViewJudul;
        TextView textViewDate;
        ImageView imageViewPoster;
    }
}*/