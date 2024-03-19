package pt.ipp.isep.dei.esoft.project.mappers;

import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.mappers.Dto.PropertyDto;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for mapping Property class
 * objects to property DTO.
 * It allows for data transfer and transformation between different representations.
 *
 * @author Gustavo Lima (1221349)
 */
public class PropertyMapper {
    /**
     * Converts a Property object to a PropertyDto object.
     *
     * @param property
     * @return PropertyDto
     */
    public static PropertyDto toDto(Property property) {
        return new PropertyDto(property.getName(), property.getAddress(), property.getArea(), property.getDistanceFromCenter(), property.getPrice(), property.getCity(), property.getDistrict(), property.getState(), property.getOwner(), property.getBusinessType(), property.getPhotos());
    }

    /**
     * Retrieves all Property objects from the PropertyRepository,
     * converts them to PropertyDto objects using the toDto method,
     * and returns a list of the resulting PropertyDto objects.
     *
     * @param propertyRepository
     * @return List<PropertyDto>
     */
    public List<PropertyDto> toDto(PropertyRepository propertyRepository) {
            List<Property> properties = propertyRepository.getAllProperties();
            List<PropertyDto> propertyDto = new ArrayList<>();

            for (Property property : properties) {
                propertyDto.add(this.toDto(property));
            }

            return propertyDto;
    }
}
