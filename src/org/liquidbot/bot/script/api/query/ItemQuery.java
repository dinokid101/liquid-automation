package org.liquidbot.bot.script.api.query;

import org.liquidbot.bot.script.api.interfaces.Filter;
import org.liquidbot.bot.script.api.methods.data.Inventory;
import org.liquidbot.bot.script.api.wrappers.Item;

import java.util.Arrays;

/**
 * Created on 8/4/2014.
 */
public class ItemQuery extends AbstractQuery<ItemQuery, Item> {

    @Override
    protected Item[] elements() {
        return Inventory.getAllItems();
    }

    public ItemQuery name(final String... names) {
        return filter(new Filter<Item>() {
            @Override
            public boolean accept(Item item) {
                return Arrays.asList(names).contains(item.getName());
            }
        });
    }

    public ItemQuery id(final int... ids) {
        return filter(new Filter<Item>() {
            @Override
            public boolean accept(Item item) {
                return Arrays.asList(ids).contains(item.getId());
            }
        });
    }

    @Override
    public Item nil() {
        return Inventory.nil();
    }
}
