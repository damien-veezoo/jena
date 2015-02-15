/**
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  See the NOTICE file distributed with this work for additional
 *  information regarding copyright ownership.
 */

package dev;


public class NOTES {
    // Mantis / cohort / legion
    
    // promotion - trim path once duplicated so once per operation.
    //    Or switch to limit effects now.
    //    or page.setModified.

    // Switch to HWM per operation at least. 
    
    // Rework block trakcing.
    //  Only worry about write blocks (iterator are read and confusing?)
    //  Start batch - stact tracking - finish batch - check all written.
    //  Free block management.
    //  page release tracking / non-iterators.
    //  page release tracking / write blocks / either write or release. 

    // BPTreeNode.promoteRoot
    // check root handling.  Do in BPlusTree?
    
    // Remove CheckingTree - broken.

    // Clear up being/end bracketing.
    
    // RecordBufferPage._reset -- wrong?? format?
    
    // BlockAccessBase/BlockAccessMapped needs to track highest block better.
    // Delete BlockMgrSync - used by BlockMgrCahe
    
    // Free chain management for MVCC block mgrs.  BlockMgrFreeChain is enough?
    
    // Modes
    //   MVCC - all old is immutable 
    //   Segments - "super transactions" all contigous writers are one update area. Need journaled blocks. Maybe bad idea.
    //   MR|SW mode
    //   Autocommit - HWM per operation.
    //   Always duplicate (testing)
    
    // == Base 
    // Move LocationLock next to StoreConnection.
    
    // == Transactions
    
    // TransactionCoordinator.start() -- helper ?
    
    // Delayed write back by leaving stuff in the journal.
    //   Avoids needing to sync the BPTs (leave to natural file caching)
    //   Avoids need to flush the new root to disk.
    
    // TransactionCoordinator.haltedMode
    // TransactionCoordinator.activeMode
    
    // Recovery: recover(Redo/undo, data);
    // Prepare: journal.writeREDO, journal.writeUNDO
    // Journal for components: only  writeREDO, writeUNDO
    
    // ObjectFile system transactions
    
    // Promotable transactions:
    //    Two counters, writer leading and trailing edge.
    //    R transactions note their start generation.
    //    Can promote IFF that is still the generation at the point of promotion.
    
    // ComponentId
    //   Registry
    //   Base bytes and index. (6 bytes + 2 bytes (=64k))?
    // TransactionalComponentLifecycle.super(ComponentId)
}

