/*
 * Copyright (c) CraftInSpace (craftin.space) 2016. All rights reserved.
 */

package space.craftin.plugin.core.api.core.functions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention (RetentionPolicy.RUNTIME)
@Target ({ElementType.FIELD})
public @interface NoSerialization {
}
