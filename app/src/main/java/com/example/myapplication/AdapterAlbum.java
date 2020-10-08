package com.example.myapplication;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class AdapterAlbum extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<String> list;

    public AdapterAlbum(List<String> list){
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        switch (viewType){
            case 1:
                View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.album_photo,parent,false);
                final MyVeiwHorlder horlder=new MyVeiwHorlder(view);

                horlder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int k=horlder.getAdapterPosition();
                        PhotoView.actionStart(horlder.view.getContext(),list.get(k));
                    }
                });

                horlder.dislike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int k=horlder.getAdapterPosition();
                        //               删除自带默认动画
                        removeData(list.get(k),k);
                    }
                });

                return  horlder;
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                TYPE2((MyVeiwHorlder) holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class MyVeiwHorlder extends RecyclerView.ViewHolder{
        private  View view;

        private  final ImageView dislike;
        private  final ImageView photo;


        public MyVeiwHorlder(View itemView) {
            super(itemView);
            view=itemView;
            dislike=(ImageView) itemView.findViewById(R.id.dislike) ;
            photo = (ImageView) itemView.findViewById(R.id.photo);

        }
    }

    private void TYPE2(MyVeiwHorlder viewHorlder,int position){

        viewHorlder.photo.setImageURI(Uri.fromFile(new File(list.get(position))));
        viewHorlder.dislike.setImageResource(R.drawable.dislike);
    }



    @Override
    public int getItemViewType(int position) {

        return 1;
    }

    public void removeData(String string,int position) {


        File file = new File(string);
        file.delete();
        list.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }


//    private void deleteDirectory(File tempFile) {
//        try {
//
//            if(tempFile.isDirectory()){
//                File[] files = tempFile.listFiles();
//                if(files == null || files.length == 0) {
//                    tempFile.delete();
//                    return;
//                }
//                for (File file: files){
//                    if(file.isFile()){
//                        file.delete();
//                    } else if(file.isDirectory()){
//                        deleteDirectory(file);
//                    }
//                }
//                tempFile.delete();
//            }else {
//                tempFile.delete();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}


