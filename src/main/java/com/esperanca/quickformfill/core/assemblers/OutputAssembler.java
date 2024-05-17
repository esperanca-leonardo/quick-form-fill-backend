package com.esperanca.quickformfill.core.assemblers;

import java.util.List;

public interface OutputAssembler<Entity, Output> {

    Output toOutput(Entity entity);

    List<Output> toCollectionOutput(List<Entity> entities);
}
