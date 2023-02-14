package com.example.apitask.View;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.apitask.Adapter.ProductAdapter;
import com.example.apitask.Model.Product;
import com.example.apitask.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
   private RecyclerView recyclerView;
    private  List<Product> productList;
    private RequestQueue requestQueue;
    private final String url="https://pqstec.com/invoiceapps/Values/GetProductList";
    private final String apiKey="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySWQiOiI3OCIsIkN1cnJlbnRDb21JZCI6IjEiLCJuYmYiOjE2NzYwOTMwNjEsImV4cCI6MTY3NjY5Nzg2MSwiaWF0IjoxNjc2MDkzMDYxfQ.mTgT0m9L9VZ1L2d41IGTVFoCpnoIQdexTxBjaZEnBGw";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.product_recyclerview);
        processData();



    }
    public void processData(){
        productList=new ArrayList<>();
        requestQueue= Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest request=
                new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                       // Toast.makeText(MainActivity.this, response.toString(),Toast.LENGTH_LONG).show();
                        try{
                            JSONArray jsonArray=response.getJSONArray("ProductList");
                            for(int i=0;i<jsonArray.length();i++){
                                Product product=new Product();
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                product.setCategoryName(jsonObject.getString("CategoryName"));
                                product.setName(jsonObject.getString("Name"));
                                product.setCode(Integer.parseInt(jsonObject.getString("Code")));
                                product.setProductBarcode(jsonObject.getInt("ProductBarcode"));
                                product.setSizeName(jsonObject.getString("SizeName"));
                                product.setDescription(jsonObject.getString("Description"));
                                product.setBrandName(jsonObject.getString("BrandName"));
                                product.setColorName(jsonObject.getString("ColorName"));
                                product.setModelName(jsonObject.getString("ModelName"));
                                product.setPrice(jsonObject.getDouble("Price"));
                                product.setOldPrice(jsonObject.getDouble("OldPrice"));
                                product.setImagePath(jsonObject.getString("ImagePath"));
                                productList.add(product);



                            }
                            ProductAdapter productAdapter=new ProductAdapter(productList);
                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false));
                            recyclerView.setAdapter(productAdapter);
                           // Toast.makeText(MainActivity.this, "hello"+productList.size(),Toast.LENGTH_LONG).show();

                        }catch (Exception e){
                            e.printStackTrace();

                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "error",Toast.LENGTH_LONG).show();
                    }
                }){
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {


                        Map<String, String> header = new HashMap<>();
                        header.put("content-type", "application/json");
                        header.put("authorization", "Bearer " + apiKey);
                        return header;


                    }
                };
        requestQueue.add(request);
    }
}