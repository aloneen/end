package kz.seisen.end.services;



import kz.seisen.end.dto.ItemDto;

import java.util.List;

public interface ItemService {

    List<ItemDto> getAll();
    ItemDto getById(Long id);
    ItemDto create(ItemDto dto);
    ItemDto update(Long id, ItemDto dto);
    boolean delete(Long id);


}
