package bg.softuni.hateoas.web;

import bg.softuni.hateoas.model.Course;
import bg.softuni.hateoas.model.Order;
import bg.softuni.hateoas.model.OrderDTO;
import bg.softuni.hateoas.model.Student;
import bg.softuni.hateoas.repository.CourseRepository;
import bg.softuni.hateoas.repository.OrderRepository;
import bg.softuni.hateoas.repository.StudentRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrderRepository orderRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public OrdersController(OrderRepository orderRepository,
                            CourseRepository courseRepository,
                            StudentRepository studentRepository) {
        this.orderRepository = orderRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public ResponseEntity<EntityModel<OrderDTO>> createOrder(
            @RequestBody OrderDTO orderDTO){
        //TODO: validation
        Student student = studentRepository.getOne(orderDTO.getId());
        Course course = courseRepository.getOne(orderDTO.getId());

        Order newOrder = new Order();
        newOrder.setStudent(student);
        newOrder.setCourse(course);

        newOrder = this.orderRepository.save(newOrder);

        //todo build order links

        return ResponseEntity.ok(EntityModel.of(OrderDTO.asDTO(newOrder)));
    }
}
