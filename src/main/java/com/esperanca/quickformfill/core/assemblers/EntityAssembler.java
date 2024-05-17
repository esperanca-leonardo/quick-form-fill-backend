package com.esperanca.quickformfill.core.assemblers;

public interface EntityAssembler<Entity, Input> {

    Entity toEntity(Input input);
}
