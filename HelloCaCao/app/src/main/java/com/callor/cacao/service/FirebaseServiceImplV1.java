package com.callor.cacao.service;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.callor.cacao.adpter.ChattAdapter;
import com.callor.cacao.model.Chatt;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class FirebaseServiceImplV1 implements ChildEventListener {

    /**
     * chattAdapter 객체가 하는일
     * RecyclerView와 연동하여 데이터를 화면에 그리기 위한 중간 연결도구
     *
     *
     */
    private ChattAdapter apdapter;

    public FirebaseServiceImplV1(ChattAdapter apdapter) {
        this.apdapter = apdapter;
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
        Chatt chattVO = snapshot.getValue(Chatt.class);
        apdapter.addChatList(chattVO);
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}
