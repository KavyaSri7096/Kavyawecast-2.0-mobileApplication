package com.wecast.mobile.ui.screen.live.channel;

import android.content.Context;

import com.wecast.core.data.db.entities.Channel;
import com.wecast.mobile.databinding.CardChannelFavoriteBinding;
import com.wecast.mobile.ui.ScreenRouter;
import com.wecast.mobile.ui.base.BaseViewHolder;

import androidx.databinding.ViewDataBinding;

/**
 * Created by ageech@live.com
 */

public class ChannelFavoriteViewHolder extends BaseViewHolder<Channel> implements ChannelFavoriteViewModel.OnClickListener {

    private CardChannelFavoriteBinding binding;
    private ChannelFavoriteViewModel viewModel;

    public ChannelFavoriteViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = (CardChannelFavoriteBinding) binding;
    }

    @Override
    public void onBind(Channel item) {
        viewModel = new ChannelFavoriteViewModel(item, this);
        binding.setViewModel(viewModel);

        // Immediate Binding
        // When a variable or observable changes, the binding will be scheduled to change before
        // the next frame. There are times, however, when binding must be executed immediately.
        // To force execution, use the executePendingBindings() method.
        binding.executePendingBindings();
    }

    @Override
    public void onItemClick(Channel item) {
        if (item != null) {
            Context context = binding.getRoot().getContext();
            ScreenRouter.openChannelDetails(context, item);
        }
    }
}