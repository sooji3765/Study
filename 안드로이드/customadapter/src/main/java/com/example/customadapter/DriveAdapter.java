package com.example.customadapter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customadapter.DTO.DriveDto;

import java.util.ArrayList;
import java.util.List;

public class DriveAdapter extends ArrayAdapter<DriveDto> {

    Context context;
    int resId;
    ArrayList<DriveDto> datas;

    public DriveAdapter(Context context, int resId, ArrayList<DriveDto> datas) {
        super(context,resId);
        this.context = context;
        this.resId = resId;
        this.datas=datas;

    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId,null);
            DriveHolder holder = new DriveHolder(convertView);
            convertView.setTag(holder);
        }
        DriveHolder holder = (DriveHolder)convertView.getTag();

        ImageView typeImageView = holder.typeImageView;
        TextView titleView = holder.titleView;
        TextView dateView = holder.dateView;
        ImageView menuImageView = holder.menuView;

        final DriveDto dto = datas.get(position);

        titleView.setText(dto.getTitle());
        dateView.setText(dto.getDate());

        if (dto.getType().equals("doc")){
            typeImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(),R.drawable.ic_content_document,null));
        }else if (dto.getType().equals("image")){
            typeImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(),R.drawable.ic_image_black_24dp,null));
        }else if (dto.getType().equals("file")){
            typeImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(),R.drawable.ic_attach_file_black_24dp,null));
        }

        menuImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,dto.getTitle()+"menu click",Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
