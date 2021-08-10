package com.callor.library.apdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.library.databinding.BookItemViewBinding;
import com.callor.library.model.BookDTO;

import java.util.List;

public class BookApdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<BookDTO> bookList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return bookList == null ? 0 : bookList.size();
    }

    /**
     * 각 데이터 아이템을 표시하기 위한 view 객체 생성하기 
     */
    public static class BookViewHolder extends RecyclerView.ViewHolder{

        /**
         * DataBinding이 true로 되어 있을때
         * book_item_view.xml layout 파일을 생성하면
         * 자동으로 선언되는 클래스
         */
        public BookItemViewBinding bookItemView;

        public BookViewHolder(@NonNull BookItemViewBinding bookItemViewBinding) {
            super(bookItemViewBinding.getRoot());
            bookItemView = bookItemViewBinding;
        }

        public void bind(BookDTO bookDTO){


        }

    }
}
