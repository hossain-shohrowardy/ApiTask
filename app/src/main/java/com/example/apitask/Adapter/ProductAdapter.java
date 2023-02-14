package com.example.apitask.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apitask.Model.Product;
import com.example.apitask.R;


import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent,false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Product product=productList.get(position);
     /*   if(product.getImagePath().isEmpty() || product.getImagePath()==null){
            holder.productImg.setImageResource(R.drawable.default_product_image);

        }
        else{
            String baseUrl="https://pqstec.com/invoiceapps/Values/GetProductList";
            Glide.with(holder.productImg.getContext()).load(Uri.parse(baseUrl+product.getImagePath())).into(holder.productImg);
        }*/
        holder.productImg.setImageResource(R.drawable.default_product_image);
        holder.category.setText("Category : "+ product.getCategoryName());
        holder.description.setText("Description : "+" Name - "+ product.getName()+", Brand - "+product.getBrandName()+ ", Size - "+product.getSizeName()+", Previous Price - "+product.getOldPrice() );
        holder.price.setText("Price : "+ product.getPrice());
        holder.code.setText("Code : "+ product.getCode());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder{
    ImageView productImg;
    TextView category,description,price,code;
    public ProductHolder(@NonNull View itemView) {
        super(itemView);
        productImg=(ImageView) itemView.findViewById(R.id.product_img);
        category=(TextView) itemView.findViewById(R.id.product_category);
        description=(TextView) itemView.findViewById(R.id.pruduct_des);
        price=(TextView) itemView.findViewById(R.id.product_price);
        code=(TextView) itemView.findViewById(R.id.product_code);
    }
}
}
