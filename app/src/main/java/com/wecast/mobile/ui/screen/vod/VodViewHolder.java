package com.wecast.mobile.ui.screen.vod;

import android.content.Context;

import com.wecast.core.data.db.entities.ShowType;
import com.wecast.core.data.db.entities.Vod;
import com.wecast.mobile.databinding.CardVodBinding;
import com.wecast.mobile.ui.ScreenRouter;
import com.wecast.mobile.ui.base.BaseViewHolder;
import com.wecast.mobile.ui.common.adapter.ItemMultiChoiceAdapter;

import androidx.databinding.ViewDataBinding;

/**
 * Created by ageech@live.com
 */

public class VodViewHolder extends BaseViewHolder<Vod> implements VodViewModel.OnClickListener {

    private CardVodBinding binding;
    private VodViewModel viewModel;

    public VodViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = (CardVodBinding) binding;
    }

    @Override
    public void onBind(Vod item) {
        viewModel = new VodViewModel(item, this);
        binding.setViewModel(viewModel);

        // Immediate Binding
        // When a variable or observable changes, the binding will be scheduled to change before
        // the next frame. There are times, however, when binding must be executed immediately.
        // To force execution, use the executePendingBindings() method.
        binding.executePendingBindings();
    }

    @Override
    public void onItemClick(Vod item) {
        if (item != null) {
            Context context = binding.getRoot().getContext();
            ScreenRouter.openVodDetails(context, item);
        }
    }
}