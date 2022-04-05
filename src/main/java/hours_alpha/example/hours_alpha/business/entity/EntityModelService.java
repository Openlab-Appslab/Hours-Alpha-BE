package hours_alpha.example.hours_alpha.business.entity;

public interface EntityModelService<T extends EntityModel> {
    T getUserByEmail(String email);
}
