package com.ar.androidforbeginer.app.adapter;

//http://stackoverflow.com/questions/26585941/recyclerview-header-and-footer

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ar.androidforbeginer.R;
import com.ar.androidforbeginer.app.model.Member;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapter.MyViewHolder> {
    private ArrayList<Member> data;
    private LayoutInflater inflater;
    private Context context;
    private AdapterView.OnItemClickListener onItemClickListener;

    public MemberListAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = new ArrayList<>();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ArrayList<Member> getListMember() {
        return data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_member, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Member member = data.get(position);
        holder.position = position;

        final long identity = System.currentTimeMillis();
        holder.identity = identity;

        if (member.getGeneral_info().getPhoto().length() != 0){
            Picasso.with(context).
                    load(member.getGeneral_info().getPhoto()).
                    into(holder.img_member);
        }

        holder.txt_member_name.setText(member.getGeneral_info().getName());
        holder.txt_member_address.setText(member.getGeneral_info().getAddress());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        int position;
        TextView txt_member_name, txt_member_address;
        ImageView img_member;
        long identity;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            img_member = (ImageView) itemView.findViewById(R.id.img_member);
            txt_member_name = (TextView) itemView.findViewById(R.id.txt_member_name);
            txt_member_address = (TextView) itemView.findViewById(R.id.txt_member_address);

        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null){
                onItemClickListener.onItemClick(null, v, position, 0);
            }
        }
    }
}
