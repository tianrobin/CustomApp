package com.custom.dao.system;

import com.custom.common.IOperations;
import com.custom.modle.system.Sequence;
import com.custom.type.SequenceNameEnum;

/**
 * Created by robin.tian on 16-3-31.
 */
public interface SequenceDao extends IOperations<Sequence> {

    String getNextSequence(SequenceNameEnum name);
}
