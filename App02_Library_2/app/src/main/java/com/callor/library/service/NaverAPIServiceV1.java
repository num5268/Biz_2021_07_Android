package com.callor.library.service;

import android.util.Log;

import com.callor.library.config.Naver;
import com.callor.library.model.NaverParent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverAPIServiceV1 extends Thread{

    private NaverParent naverParent = null;

    // 3. 생성된 Connection을 통하여 데이터를 가져오고
    // 필요한 데이터를 parsing하여 books 객체에 담기
    public void getNaverBooks(String search) {

        // 아래의 코드를 실행하면 Retrofit 설정된 값을 기준으로
        // naver에 요청을 수행한다
        // 이때 이 코드는 비동기 방식으로 작동이 된다.
        Call<NaverParent> naverCall = RetrofitClient.getClient()
                .getNaverBook(Naver.CLIENT_ID,Naver.CLIENT_SECRET, search);

        /**
         * Retrofit 은 API요청을 비동기 방식으로 수행을 한다
         * 일반적으로 Network이나 외부 다른 장치와 데이터를 주고 받을때는
         * 대부분의 코드를 비동기, 또는 thread 방식으로 사용한다
         *
         * 동기방식
         * 요청수행 ===> 결과가 return 되어 올때까지 대기
         *
         * 비동기방식
         * 요청수행 ===> 결과가 return 되든 말든 다른일 수행하기
         * 결과 return되면 그 결과를 수신하여 처리할 event hander를
         *      작성해야 한다.
         */
        // Retrofit event 핸들러 작성

        naverCall.enqueue(new Callback<NaverParent>() {


            @Override
            public void onResponse(Call<NaverParent> call, Response<NaverParent> response) {
                // return된 response 객체 확인
                Log.d("Naver Res Return",response.toString());
                int resCode = response.code();
                if(resCode < 300){
                    naverParent = response.body();
                    Log.d("Naver Return",naverParent.toString());
                }

                // return된 response 객체에서 데이터만 추출

            }

            @Override
            public void onFailure(Call<NaverParent> call, Throwable t) {
                Log.d("오류가 발생했음",t.toString());
            }
        });

    }




}
