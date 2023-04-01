package com.chaosthedude.naturescompass.mixins;

import com.chaosthedude.naturescompass.workers.WorldWorkerManager;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

@Mixin(MinecraftServer.class)
public class ServerMixin {

    @Inject(method = "tick(Ljava/util/function/BooleanSupplier;)V", at = @At(value = "HEAD"))
    private void startTick(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        WorldWorkerManager.tick(true);
    }

    @Inject(method = "tick(Ljava/util/function/BooleanSupplier;)V", at = @At(value = "TAIL"))
    private void endTick(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        WorldWorkerManager.tick(false);
    }

    @Inject(method = "shutdown()V", at = @At(value = "TAIL"))
    private void onShutdown(CallbackInfo ci) {
        WorldWorkerManager.clear();
    }

}
