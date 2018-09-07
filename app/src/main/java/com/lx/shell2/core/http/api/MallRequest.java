package com.lx.shell2.core.http.api;


import com.lx.shell2.entity.LoginBackBean;
import com.lx.shell2.entity.WorkListBackBean;


import java.util.TreeMap;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


/**
 * Created by lixu on 2016/11/29.
 * updated by lixu on 2018/08/17
 */
public interface MallRequest {
    /**
     * GET请求
     *
     * @param url     api接口url
     * @param request 请求参数map
     * @return
     */
//    @GET
//    Observable<HttpResponse> get(@Url String url, @QueryMap TreeMap<String, Object> request);

    /**
     * POST请求
     *
     * @return
     */
//    @FormUrlEncoded
//    @POST
//    Observable<HttpResponse> post(@Url String url, @FieldMap TreeMap<String, Object> request);

    @FormUrlEncoded
    @POST(AllUrl.loginUrl)
    Observable<LoginBackBean> login(@Field("useraccount") String userName, @Field("password") String pwd);

    @FormUrlEncoded
    @POST(AllUrl.queryList)
    Observable<WorkListBackBean> getWorkList(@Field("UID") String uid
            , @Field("start") String page
            , @Field("pageSize") String pageSize
            , @Field("cityId") String cityId
            , @Field("countyId") String countyId);

    /**
     * 上传一张图片
     *
     * @return
     */
    /*@Multipart
    @POST(AllUrl.uploadImageTrue)
    Call<StringBean> uploadImageTrue(@PartMap Map<String, RequestBody> params);
    @FormUrlEncoded
    @POST(AllUrl.uploadImage)
    Call<UpLoadResult> uploadImage(
            @Field("id") String id
            , @Field("photoString") String photoString);*/



    /*@Multipart
    @POST()
    Call<ResponseBody> uploadFiles(@Url String url, @PartMap() Map<String, RequestBody> maps);
    @Multipart
    @POST
    Call<ResponseBody> uploadFileWithPartMap(
            @Url() String url,
            @PartMap() Map<String, RequestBody> partMap,
            @Part("file") MultipartBody.Part file);
    @Multipart
    @POST(AllUrl.uploadImage)
    Call<String> updateImage(@Part MultipartBody.Part[] file, @QueryMap Map<String, String> maps);
    @Streaming //大文件时要加不然会OOM
    @FormUrlEncoded
    @POST
    Call<ResponseBody> downloadFile(@Url String fileUrl, @Field("jsonRequest") String jsonRequest);*/

//    //上传图片
//    @FormUrlEncoded
//    @POST(AllUrl.upload)
//    Observable<SaveTaoBean> upload(@Field("resType") String resType
//            , @Field("resName") String resName,
//                                   @Field("deliveryCategory") String deliveryCategory,
//                                   @Field("deliveryItem") String deliveryItem,
//                                   @Field("ZhLabel") String ZhLabel,
//                                   @Field("file") String file
//            , @Field("resourceid") String resourceid
//            , @Field("uid") String uid);

}