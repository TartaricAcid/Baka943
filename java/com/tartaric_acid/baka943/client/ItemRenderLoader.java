package com.tartaric_acid.baka943.client;

import com.tartaric_acid.baka943.block.BlockLoader;
import com.tartaric_acid.baka943.item.ItemLoader;

public class ItemRenderLoader {
	public ItemRenderLoader()
    {
        BlockLoader.registerRenders();
        ItemLoader.registerRenders();
    }
}
