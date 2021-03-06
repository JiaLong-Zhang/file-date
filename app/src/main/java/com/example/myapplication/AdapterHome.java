package com.example.myapplication;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<String> list;

    public AdapterHome(List<String> list){
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case 1:
                View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
                final MyVeiwHorlder horlder=new MyVeiwHorlder(view);

                horlder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int k=horlder.getAdapterPosition();
                        File pictureDir = Environment
                                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

                        final String GalleryPath = pictureDir
                                + File.separator+ "MyCameraGallery" + File.separator+ list.get(k);
                        Album.actionStart(horlder.view.getContext(),GalleryPath);
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
        private final TextView title_two;
        private  final ImageView dislike;


        public MyVeiwHorlder(View itemView) {
            super(itemView);
            view=itemView;
            dislike=(ImageView) itemView.findViewById(R.id.dislike) ;
            title_two = (TextView) itemView.findViewById(R.id.title_Two);

        }
    }

    private void TYPE2(MyVeiwHorlder viewHorlder,int position){

        viewHorlder.title_two.setText(list.get(position));
        viewHorlder.dislike.setImageResource(R.drawable.dislike);
    }



    @Override
    public int getItemViewType(int position) {

        return 1;
    }

    public void removeData(String string,int position) {

        File pictureDir = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        final String GalleryPath = pictureDir
                + File.separator+ "MyCameraGallery" + File.separator+ string;
        File file = new File(GalleryPath);
        delete(file);


        list.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

      public static void delete(File file) {
                    File[] childFiles = file.listFiles();
                      if (childFiles == null || childFiles.length == 0) {
                              file.delete();
                               return;
                          }

                     for (int i = 0; i < childFiles.length; i++) {
                            delete(childFiles[i]);
                           }
                     file.delete();

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


