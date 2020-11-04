package dzwdz.bundles_of_unstackables.mixin;

import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleItem.class)
public class BundleItemMixin {
    @Inject(
            at = @At("HEAD"),
            method = "Lnet/minecraft/world/item/BundleItem;getWeight(Lnet/minecraft/world/item/ItemStack;)I",
            cancellable = true
    )
    private static void overrideWeight(ItemStack itemStack, CallbackInfoReturnable<Integer> callbackInfo) {
        if (itemStack.getMaxStackSize() == 1)
            callbackInfo.setReturnValue(4);
    }
}
