package com.callor.cacao.adpter;


import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.cacao.R;
import com.callor.cacao.model.Chatt;

import java.util.List;


public class ChattAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private List<Chatt> chattList;
    private String name;

    /**
     * 외부에서 chatt 데이터 아이템을 List를 추가하고
     * 추가된 List는 RecyclerView를 통해서
     *      화면에 다시 그려지게 될 것이다
     * @param chatt
     */
    public void addChatList(Chatt chatt) {

        chattList.add(chatt);

        notifyItemInserted(chattList.size() - 1);

    }


    /**
     * RecyclerView가 화면에 그릴 데이터들을 전달받을 통로
     * @param chattList
     */
    public ChattAdapter(List<Chatt> chattList) {

        // this.chattList = chattList;
        this(chattList, "익명");
    }

    public ChattAdapter(List<Chatt> chattList, String name) {

        this.chattList = chattList;
        this.name = name;
    }

    /**
     * chat_item.xml파일을 읽어서 한개의 아이템을 화면에 그릴 준비
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item_layout
            = LayoutInflater.from( parent.getContext() )
            .inflate(R.layout.chatt_item,parent,false);

        ChattViewHolder viewHolder
                = new ChattViewHolder(item_layout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull
            RecyclerView.ViewHolder holder, int position) {

        Chatt chat = chattList.get(position);
        ChattViewHolder chattViewHolder
                = (ChattViewHolder) holder;

        chattViewHolder.item_name.setText(chat.getName());
        chattViewHolder.item_msg.setText(chat.getMsg());

        /**
         * 현재 App에서 보낸 메세지를 DB에서 가져왔으면(Fetch)
         * this.name 변수에는 App에 설정된 nickname이 담겨있다
         * 그리고 firebase에서 가져온 데이터에서 이름이 nickname과 같으면
         * 오른쪽 정렬하여 보여라
         */
        if(this.name.equals(chat.getName())){

            // 이름과 메세지를 오른쪽 정렬
            chattViewHolder.item_name.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            chattViewHolder.item_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);

            chattViewHolder.msgLinear.setGravity(Gravity.END);
            chattViewHolder.item_msg.setBackgroundColor(Color.parseColor("FF#B3B"));
        }
    }

    /**
     * RecyclerView가 데이터들을 화면에 표시할때
     * 참조하는 함수
     * @return
     */
    @Override
    public int getItemCount() {
        return chattList == null ? 0 : chattList.size();
    }

    public static class ChattViewHolder
            extends RecyclerView.ViewHolder{

        public TextView item_name;
        public TextView item_msg;

        public LinearLayout msgLinear;

        public ChattViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_msg = itemView.findViewById(R.id.item_msg);

            /**
             * item_name과 item_msg를 감싸고 있는 layout(Linear
             */
            msgLinear = itemView.findViewById(R.id.msg_linear);
        }
    }

}
