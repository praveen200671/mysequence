package com.meditation.my_sequence.dto;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_history")  
public class UserSequenceHistoryEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sequence_id")
    private Integer sequenceId;

    @Column(name = "play_duration")
    private Integer playDuration;

    private LocalDateTime timestamp;

    @Column(name = "user_id")
    private Integer userId;

}
