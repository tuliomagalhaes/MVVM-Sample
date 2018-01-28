package com.tuliohdev.mvvmsample.ui.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tuliohdev.mvvmsample.R;
import com.tuliohdev.mvvmsample.data.model.presentationmodel.CreditCardPM;
import java.util.List;

/**
 * Created by tulio on 26/01/18.
 */

public class CreditCardAdapter extends RecyclerView.Adapter<CreditCardAdapter.ItemViewHolder> {

    private List<CreditCardPM> mCreditCardPMList;

    public CreditCardAdapter(List<CreditCardPM> creditCardPMList) {
        mCreditCardPMList = creditCardPMList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recylerview_item_credit_card, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        CreditCardPM creditCardPM = mCreditCardPMList.get(position);

        holder.tvNumber.setText(creditCardPM.getNumber());
        holder.tvCVV.setText(creditCardPM.getCvv());
        holder.tvExpirationDate.setText(creditCardPM.getExpirationDate());
        holder.tvName.setText(creditCardPM.getName());
        holder.ivBrand.setImageDrawable(creditCardPM.getBrandType());
    }

    @Override
    public int getItemCount() {
        return mCreditCardPMList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvNumber) TextView tvNumber;
        @BindView(R.id.tvCVV) TextView tvCVV;
        @BindView(R.id.tvExpirationDate) TextView tvExpirationDate;
        @BindView(R.id.tvName) TextView tvName;
        @BindView(R.id.ivBrand) ImageView ivBrand;

        ItemViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
